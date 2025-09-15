import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LagrangeInterpolatedFunction implements  CalculatedFunction{
    private Double[] xCord;
    private Double[] yCord;

    private LagrangeInterpolatedFunction(Double[] xCord, Double[] yCord) {
        this.xCord = xCord;
        this.yCord = yCord;
    }

    public static LagrangeInterpolatedFunction fromCsv(String path) {
        BufferedReader reader = null;
        String line = "";
        List<Double> xCordList = new ArrayList<>();
        List<Double> yCordList = new ArrayList<>();
        String[] split = null;
        List<String> stringList = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(path));
            while ((line = reader.readLine()) != null) {
                split = line.split(",");
                for (int i = 0; i < split.length; i++) {
                    stringList.add(split[i]);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        for (int i = 0; i < stringList.size() - 1; i++) {
            if (i % 2 == 0){
                xCordList.add(Double.parseDouble(stringList.get(i)));
                yCordList.add(Double.parseDouble(stringList.get(i + 1)));
            }

           yCordList.add(Double.parseDouble(stringList.get(i + 1)));


        }
        Double[] xCord = new Double[xCordList.size()];
        Double[] yCord = new Double[yCordList.size()];
        for (int i = 0; i < xCordList.size(); i++) {
            xCord[i] = xCordList.get(i);
        }

        for (int i = 0; i < yCordList.size(); i++) {
            yCord[i] = yCordList.get(i);
        }

        LagrangeInterpolatedFunction lagrangeInterpolatedFunction = new LagrangeInterpolatedFunction(xCord, yCord);

        for (int i = 0; i < xCordList.size(); i++) {
            System.out.println("x=" +xCordList.get(i) + " y=" + yCordList.get(i));
        }

        return lagrangeInterpolatedFunction;
    }

    public Double[] getSortedxCord() {
        List<Double> xCordList = new ArrayList<>();

        for (int i = 0; i < xCord.length; i++) {
            xCordList.add(xCord[i]);
        }
        for (int i = 0; i < xCordList.size(); i++) {
            xCordList.sort(Double::compare);
        }

        Double[] sorteXCord = new Double[xCordList.size()];
        for (int i = 0; i < xCordList.size(); i++) {
            sorteXCord[i] = xCordList.get(i);
        }

        return sorteXCord;
    }


    @Override
    public double f(double x) {
        return LagrangeInterpolation.interpolation(xCord,yCord,x);
    }
}
