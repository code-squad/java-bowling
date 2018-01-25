package bowling.view;

import bowling.dto.FrameDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    public static void viewScore(String name, List<FrameDTO> frames){
        viewHeader();

        StringBuilder builder = new StringBuilder("| " + String.format("%-4s", name)+ " |");

        for(FrameDTO dto : frames){
            builder.append("  ")
                    .append(String.format("%-4s", dto.getExpress()))
                    .append("|");
        }

        System.out.println(builder.toString());
    }

    private static void viewHeader(){
        String result = "| NAME |" +
                String.join("", IntStream.range(1, 11)
                        .mapToObj(v -> String.format("  %02d  |", v))
                        .collect(Collectors.toList()));

        System.out.println(result);
    }

}
