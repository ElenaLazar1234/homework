package Coding_Assignment2;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.LocalDate;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {
    public static void main (String[] args){

        List<PackageDelivery> packages = readFromFile("src/main/java/Coding_Assignment2/Data.txt");

    }

    public static List<PackageDelivery> readFromFile(String pathString){

        List<PackageDelivery> packagesDelivery = new ArrayList<>();
        try{
        Path path = Paths.get(pathString);
        List<String> packageDeliveriesStrings = Files.lines(path)
                .map(a->a.split(","))
                .flatMap(Arrays::stream)
                .filter(StringUtils::isNotEmpty).collect(Collectors.toList());

        for( int i = 0 ; i < packageDeliveriesStrings.size();i=i+4){
            PackageDelivery packageDelivery = new PackageDelivery();
            packageDelivery.targetLocation = packageDeliveriesStrings.get(i);
            packageDelivery.distance = Double.parseDouble(packageDeliveriesStrings.get(i+1));
            packageDelivery.value = Double.parseDouble(packageDeliveriesStrings.get(i+2));
            packageDelivery.deliveryDate = LocalDate.parse(packageDeliveriesStrings.get(i+3));
            packagesDelivery.add(packageDelivery);
        }

    }
    catch (IOException e){
        e.printStackTrace();
    }

      return packagesDelivery;
    }

    public static Map<String, List<PackageDelivery>> GroupPackageByTargetLocation(String targetLocation  , List<PackageDelivery> packageDeliveries ){

        Map<String,List<PackageDelivery>> packagesGroupedByTargetLocation = packageDeliveries.stream().collect( Collectors.groupingBy(s -> targetLocation));
        return packagesGroupedByTargetLocation;
    }

    public static Map<LocalDate, List<PackageDelivery>> GroupPackageByDeliveryDate(LocalDate date , List<PackageDelivery> packageDeliveries ){

        Map<LocalDate,List<PackageDelivery>> packagesGroupedByDate = packageDeliveries.stream().collect( Collectors.groupingBy(s -> date));
        return packagesGroupedByDate;
    }

}
