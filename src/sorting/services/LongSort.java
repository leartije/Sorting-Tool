package sorting.services;

import sorting.util.Msg;
import sorting.util.UtilStuff;

import java.util.*;

public class LongSort implements SortingTool {

    @Override
    public void executeNatural(boolean isFromConsole, String file) {
        List<Long> longs = readInput(isFromConsole, file);
        sortNatural(longs);
    }

    @Override
    public void executeByCount(boolean isFromConsole, String file) {
        List<Long> longs = readInput(isFromConsole, file);
        sortByCount(longs);
    }

    private List<Long> readInput(boolean isFromConsole, String file) {
        List<Long> list = new ArrayList<>();
        Scanner scanner;

        if (isFromConsole) {
            scanner = new Scanner(System.in);
        } else {
            scanner = new Scanner(file);
        }

        while (scanner.hasNext()) {
            String in = null;
            try {
                in = scanner.next();
                Long l = Long.parseLong(in);
                list.add(l);
            } catch (NumberFormatException e) {
                System.out.printf(Msg.IS_NOT_A_LONG, in);
                UtilStuff.ERRORS.add(String.format(Msg.IS_NOT_A_LONG, in));
            }

        }
        return list;
    }

    private void sortNatural(List<Long> list) {
        Collections.sort(list);
        System.out.printf(Msg.TOTAL_NUMBERS, list.size());
        System.out.print(Msg.SORTED_DATA);
        list.forEach(aLong -> System.out.print(aLong + " "));
        System.out.println();
    }


    private void sortByCount(List<Long> list) {
        Map<Long, Integer> statistic = getStatistic(list);
        Map<Long, Integer> sorted = new LinkedHashMap<>();

        statistic.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEach(x -> sorted.put(x.getKey(), x.getValue()));

        System.out.printf(Msg.TOTAL_NUMBERS, list.size());
        sorted.forEach((aLong, integer) -> System.out.printf(Msg.BY_COUNT_DATA, aLong, integer,
                UtilStuff.getPercentage(list.size(), integer)));
    }

    private Map<Long, Integer> getStatistic(List<Long> list) {
        Map<Long, Integer> mapa = new TreeMap<>();
        for (Long aLong : list) {
            mapa.put(aLong, mapa.getOrDefault(aLong, 0) + 1);
        }
        return mapa;
    }

}
