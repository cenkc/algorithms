package algorithms.assessments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://gist.github.com/cenkc/88b8ca156e82b76880cae7065e2ae56b
 *
 * created by Cenk Canarslan on 2021-07-13
 */
public class EqualCircleSegments {

    public static void main(String[] args) {
        EqualCircleSegments ecs = new EqualCircleSegments();
        Integer[] arrRadius = {1, 1, 1, 2, 2, 3};
        int segments = 6;
        List<Integer> radiusList = Arrays.asList(arrRadius);
        String result = ecs.largestSegment(radiusList, segments);
        System.out.println("result = " + result);
    }

    public String largestSegment(List<Integer> radius, int segments) {
        radius.sort((a, b) -> (b-a));
        radius.stream().forEach(z -> System.out.println(z));
//        return findLargestSegment(segments);
        // TODO: 21.10.2021 Complete...
        return "";
    }

/*
    public String largestSegment(List<Integer> radius, int segments) {
        Double pi = 3.14159265359d;
        List<Double> areas = new ArrayList<>();
        for (int i = 0; i < radius.size(); i++) {
            Integer rad = radius.get(i);
            areas.add(i, rad * rad * pi);
        }

        Map<Double, Long> circleMap = areas.stream().collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )
        );

        double[][] circles = new double[circleMap.size()][2];
        int i = 0;
        for (Map.Entry<Double, Long> entry : circleMap.entrySet()) {
            circles[i][0] = entry.getKey();
            circles[i][1] = entry.getValue().doubleValue();
            i++;
        }

        double countOfA = 0d;
        int index = 0;

        while (true) {
            double B = Math.min(segments, circles[index][0]);
            countOfA += B * circles[index][1];
            segments -= B;
            index++;
            if (segments == 0) {
                break;
            }
            if (index == circles.length) {
                break;
            }
        }
        return String.format("%.2f", countOfA);
    }
*/
}
