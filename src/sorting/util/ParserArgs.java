package sorting.util;

public class ParserArgs {

    private String sortingType;
    private String dataType;
    private String inputFile;
    private String outputFile;


    public void parse(String[] args) {
        if (args.length == 0) {
            return;
        }

        for (int i = 0; i < args.length; i++) {

            if ("-sortingType".equals(args[i])) {
                if (i + 1 > args.length - 1) {
                    this.sortingType = null;
                } else {
                    this.sortingType = args[i + 1];
                }
                continue;
            }

            if ("-dataType".equals(args[i])) {
                if (i + 1 > args.length - 1) {
                    this.dataType = null;
                } else {
                    this.dataType = args[i + 1];
                }
                continue;
            }

            if ("-inputFile".equals(args[i])) {
                this.inputFile = args[i + 1];
                continue;
            }

            if ("-outputFile".equals(args[i])) {
                this.outputFile = args[i + 1];
                continue;
            }

            if (args[i].startsWith("-")) {
                System.out.printf(Msg.NOT_VALID_PARAMETER, args[i]);
                UtilStuff.ERRORS.add(String.format(Msg.NOT_VALID_PARAMETER, args[i]));
            }
        }

    }

    public String getSortingType() {
        return sortingType;
    }

    public String getDataType() {
        return dataType;
    }

    public String getInputFile() {
        return inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
