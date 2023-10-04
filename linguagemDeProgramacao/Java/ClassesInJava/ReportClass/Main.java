class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("-=-=-=-=-=-=-File 1 named on constructor-=-=-=-=-=");
        Report report1 = new Report("report1File");
        report1.makePdfReport();
        report1.makeExcelReport();

        System.out.println("\n-=-=-=-=-=-=-File 2 named by setter method-=-=-=-=-=");
        Report report2 = new Report();
        report2.makePdfReport();
        report2.makeExcelReport();
        report2.setFileName("report2File");
        report2.makePdfReport();
        report2.makeExcelReport();
    }
}