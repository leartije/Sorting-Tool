package sorting;

import sorting.filemanager.Save;
import sorting.services.LineSort;
import sorting.services.LongSort;
import sorting.services.WordsSort;
import sorting.util.Msg;
import sorting.util.ParserArgs;
import sorting.util.UtilStuff;

import java.io.IOException;

public class Main {
    public static void main(final String[] args) throws IOException {


        ParserArgs parserArgs = new ParserArgs();
        parserArgs.parse(args);


        if (parserArgs.getSortingType() == null && parserArgs.getDataType() == null) {
            System.out.println(Msg.NO_SORTING_TYPE);
            UtilStuff.ERRORS.add(Msg.NO_SORTING_TYPE);
            return;

        }

        if (parserArgs.getDataType() == null) {
            parserArgs.setDataType("line");
        }

        boolean isFromConsole = parserArgs.getInputFile() == null;


        switch (UtilStuff.getCommand(parserArgs.getDataType())) {
            case WORD -> {
                if ("byCount".equals(parserArgs.getSortingType())) {
                    new WordsSort().executeByCount(isFromConsole, parserArgs.getInputFile());
                    break;
                }
                new WordsSort().executeNatural(isFromConsole, parserArgs.getInputFile());
            }
            case LINE -> {
                if ("byCount".equals(parserArgs.getSortingType())) {
                    new LineSort().executeByCount(isFromConsole, parserArgs.getInputFile());
                    break;
                }
                new LineSort().executeNatural(isFromConsole, parserArgs.getInputFile());
            }
            case LONG -> {
                if ("byCount".equals(parserArgs.getSortingType())) {
                    new LongSort().executeByCount(isFromConsole, parserArgs.getInputFile());
                    break;
                }
                new LongSort().executeNatural(isFromConsole, parserArgs.getInputFile());
            }
            case ERROR -> System.out.println("ERORCHINA KO KUCA");
        }


        if (parserArgs.getOutputFile() != null) {
            Save.save(parserArgs.getOutputFile());
        }


    }

}
