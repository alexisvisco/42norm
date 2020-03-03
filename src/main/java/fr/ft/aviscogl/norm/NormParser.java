package fr.ft.aviscogl.norm;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class NormParser
{
    private final static Pattern linePattern = Pattern.compile("(?<type>Error|Warning):? (?:\\(line (?<line>\\d+)(?:, col (?<offset>\\d+))?\\): )?(?<message>.+)");

    ArrayList<NormResult> parse(String output)
    {
        ArrayList<NormResult> results = new ArrayList<>();
        String[] split = output.split("\n");

        for (int i = 0; i < split.length; i++) {
            if (split[i].startsWith("Norme: ")) {
                continue;
            }

            NormResult normResult = new NormResult();
            String line = split[i];
            Matcher matcher = linePattern.matcher(line);

            while (matcher.find()) {
                if (matcher.groupCount() >= 1) {
                    try {
                        normResult.setType(NormType.valueOf(matcher.group("type").toUpperCase()));
                        normResult.setMessage(matcher.group("message"));

                        String lineMatched = matcher.group("line");
                        if (lineMatched != null) {
                            normResult.setLine(Integer.parseInt(lineMatched));
                        }

                        String offsetMatched = matcher.group("offset");
                        if (offsetMatched != null) {
                            normResult.setOffset(Integer.parseInt(offsetMatched));
                        }

                        results.add(normResult);
                    } catch (Exception ignore) {
                        ignore.printStackTrace();
                    }

                    break;
                }
            }
        }

        return results;
    }
}
