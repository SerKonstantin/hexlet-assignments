package exercise.controller;

import exercise.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import org.instancio.Instancio;
import org.instancio.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;

// BEGIN
@SpringBootTest
@AutoConfigureMockMvc
// END
class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TaskRepository taskRepository;


    @Test
    public void testWelcomePage() throws Exception {
        var result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body).contains("Welcome to Spring!");
    }

    @Test
    public void testIndex() throws Exception {
        var result = mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).isArray();
    }


    private Task generateTask() {
        return Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .supply(Select.field(Task::getTitle), () -> faker.lorem().word())
                .supply(Select.field(Task::getDescription), () -> faker.lorem().paragraph())
                .create();
    }

    // BEGIN
    private final String mockTitle = "some title";
    private final String mockDescription = "some description";

    private Task generateSomeTask() {
        return Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .supply(Select.field(Task::getTitle), () -> mockTitle)
                .supply(Select.field(Task::getDescription), () -> mockDescription)
                .create();
    }

    @Test
    public void testCreate() throws Exception {
        var taskData = generateTask();

        var request = post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(taskData));

        var result = mockMvc.perform(request)
                .andExpect(status().isCreated());

        var task = taskRepository.findByTitle(taskData.getTitle())
                .orElseThrow(() -> new ResourceNotFoundException("\ntestCreate failed\n"));

        assertThat(task.getTitle()).isEqualTo(taskData.getTitle());
        assertThat(task.getDescription()).isEqualTo(taskData.getDescription());
    }

    @Test
    public void testShow() throws Exception {
        var task = generateTask();
        taskRepository.save(task);
        var id = task.getId();

        var result = mockMvc.perform(get("/tasks/{id}", id))
                .andExpect(status().isOk())
                .andReturn();

        var responseBody = result.getResponse().getContentAsString();

        assertThatJson(responseBody).and(
                body -> body.node("title").isEqualTo(task.getTitle()),
                body -> body.node("description").isEqualTo(task.getDescription())
        );
    }

    @Test
    public void testUpdate() throws Exception {
        var task = generateSomeTask();
        taskRepository.save(task);
        var id = task.getId();

        var data = new HashMap<>();
        data.put("title", "new title");
        data.put("description", "new description");

        var request = put("/tasks/" + id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(data));

        mockMvc.perform(request)
                .andExpect(status().isOk());

        var taskToCheck = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "\ntestUpdate failed to find modified task in database after performing update\n"
                ));
        assertThat(taskToCheck.getTitle()).isEqualTo("new title");
        assertThat(taskToCheck.getDescription()).isEqualTo("new description");
    }

    @Test
    public void testDelete() throws Exception {
        var task = generateSomeTask();
        taskRepository.save(task);
        var id = task.getId();

        assertThat(taskRepository.findById(id)).isPresent();

        mockMvc.perform(delete("/tasks/" + id));

        assertThat(taskRepository.findById(id)).isEmpty();
    }
    // END
}
