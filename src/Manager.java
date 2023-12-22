public class Manager {
        public static void main(String[] args) throws Exception {
                FileHandler fileHandler = new FileHandler();
                LudoCompetitor ludoCompetitor = new LudoCompetitor(1, new Name("Abdul", "Rehman"), "UK", "Beginner", 20,
                                new int[] { 10, 20, 30, 40 });

                fileHandler.writeCompetitorToFile(ludoCompetitor, "competitor.csv");

        }
}
