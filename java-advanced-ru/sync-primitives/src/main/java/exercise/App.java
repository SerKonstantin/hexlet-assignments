package exercise;

class App {

    public static void main(String[] args) throws Exception {
        // BEGIN
        var customList = new SafetyList();
        var threadOne = new ListThread(customList);
        var threadTwo = new ListThread(customList);

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println(customList.getSize());

        // END
    }
}

