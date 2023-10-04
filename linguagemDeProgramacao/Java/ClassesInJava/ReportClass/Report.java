class Report {

    private String fileName;

    Report(String fileName) {
        this.fileName = fileName;
    }

    Report() {
        this.fileName = "Placeholder file name";
    }

    public void setFileName(String fileName) throws Exception {
        if (this.fileName == "Placeholder file name") {
            this.fileName = fileName;
            return;
        }
        throw new Exception("File name is already set.");
    }

    public String getFileName() {
        return this.fileName;
    }

    public void makePdfReport() {
        System.out.println("Making PDF report at " + this.fileName);
    }

    public void makeExcelReport() {
        System.out.println("Making Excel report at " + this.fileName);
    }
}