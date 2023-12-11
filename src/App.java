public class App {
    public static void main(String[] args) throws Exception {
        Competitor competitor1 = new Competitor(1, new Name("John", "Doe"), "USA", "Professional", 25,
                new int[] { 10, 9, 8, 7, 6 });
        Competitor competitor2 = new Competitor(2, new Name("Jane", "Doe"), "USA", "Professional", 25,
                new int[] { 10, 9, 8, 7, 6 });
        Competitor competitor3 = new Competitor(3, new Name("John", "Smith"), "USA", "Professional", 25,
                new int[] { 10, 9, 8, 7, 6 });
        Competitor competitor4 = new Competitor(4, new Name("Jane", "Smith"), "USA", "Professional", 25,
                new int[] { 10, 9, 8, 7, 6 });
        Competitor competitor5 = new Competitor(5, new Name("John", "Doe"), "USA", "Professional", 25,
                new int[] { 10, 9, 8, 7, 6 });

        System.out.println(competitor1.getCompetitorName().getFullName());
        System.out.println(competitor1.getCompetitorName().getInitials());
        System.out.println(competitor1.getCompetitorName().getFirstName());
        System.out.println(competitor1.getCompetitorName().getLastName());

    }
}
