package Coding_Assignment2;

import lombok.var;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.css.Counter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.lang.Runnable;
import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class Main implements Runnable {


    public static void main(String[] args) {

        List<PackageDelivery> packages = readFromFile("src/main/java/Coding_Assignment2/Data.txt");

        var group = GroupByTargetLocationAndDeliveryDate("Turda", LocalDate.of(2017, 9, 2), packages);

        List<PackageDelivery> groupedPackages = new ArrayList<>();

        for (var entry : group.entrySet()) {
            System.out.println("Key = " + entry.getKey());
            Map<String, List<PackageDelivery>> group2 = group.get(entry.getKey());

            for (var entry2 : group2.entrySet()) {
                System.out.println("Value=" + entry2.getKey());
                List<PackageDelivery> list = group2.get(entry2.getKey());
                System.out.println("Group value by target location and delivery date is " + groupValue(list));
                System.out.println("Group revenue  by target location and delivery date is " + groupRevenue(list) + " " + "RON");
                for (var entry3 : list) {
                    // System.out.println("Value="+entry3.getValue());

                }
                currentPackageDeliveries = list;
            }
            for (PackageDelivery packageDelivery : currentPackageDeliveries) {
                Main mainClass = new Main();
                Thread myThread = new Thread(mainClass);
                myThread.start();


            }
        }
        System.out.println("Total Value is" + " " + totalGroupValues(packages));
        System.out.println("Total Revenue is" + " " + totalGroupRevenue(packages) + " " + "RON");
    }

    public static List<PackageDelivery> readFromFile(String pathString) {

        List<PackageDelivery> packagesDelivery = new ArrayList<>();
        try {
            Path path = Paths.get(pathString);
            List<String> packageDeliveriesStrings = Files.lines(path)
                    .map(a -> a.split(","))
                    .flatMap(Arrays::stream)
                    .filter(StringUtils::isNotEmpty).collect(Collectors.toList());

            for (int i = 0; i < packageDeliveriesStrings.size(); i = i + 4) {
                PackageDelivery packageDelivery = new PackageDelivery();
                packageDelivery.targetLocation = packageDeliveriesStrings.get(i);
                packageDelivery.distance = Double.parseDouble(packageDeliveriesStrings.get(i + 1));
                packageDelivery.value = Double.parseDouble(packageDeliveriesStrings.get(i + 2));
                packageDelivery.deliveryDate = LocalDate.parse(packageDeliveriesStrings.get(i + 3));
                packagesDelivery.add(packageDelivery);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return packagesDelivery;
    }

    public static Map<String, List<PackageDelivery>> GroupPackageByTargetLocation(String targetLocation, List<PackageDelivery> packageDeliveries) {

        Map<String, List<PackageDelivery>> packagesGroupedByTargetLocation = packageDeliveries.stream().collect(Collectors.groupingBy(s -> targetLocation));
        return packagesGroupedByTargetLocation;
    }

    public static Map<LocalDate, List<PackageDelivery>> GroupPackageByDeliveryDate(LocalDate date, List<PackageDelivery> packageDeliveries) {

        Map<LocalDate, List<PackageDelivery>> packagesGroupedByDate = packageDeliveries.stream().collect(Collectors.groupingBy(s -> date));
        return packagesGroupedByDate;
    }

    public static Map<LocalDate, Map<String, List<PackageDelivery>>> GroupByTargetLocationAndDeliveryDate(String targetLocation, LocalDate deliveryDate, List<PackageDelivery> packageDeliveries) {
        //var  packages = packageDeliveries.stream().collect(Collectors.groupingBy(s->targetLocation,Collectors.mapping(t->deliveryDate, Collectors.joining(",")));
        var packagesGroupByTargetLocationAndDeliveryDate = packageDeliveries.stream().collect(Collectors.groupingBy(PackageDelivery::getDeliveryDate, Collectors.groupingBy(PackageDelivery::getTargetLocation)));

        Map<LocalDate, Map<String, List<PackageDelivery>>> packages = new HashMap<LocalDate, Map<String, List<PackageDelivery>>>();

        List<PackageDelivery> packageDeliveriesGrouped = packagesGroupByTargetLocationAndDeliveryDate.get(deliveryDate).get(targetLocation);

        Map<String, List<PackageDelivery>> packagesMap = new HashMap<String, List<PackageDelivery>>();
        packagesMap.put(targetLocation, packageDeliveriesGrouped);
        packages.put(deliveryDate, packagesMap);
        return packages;
    }

    public static double groupValue(List<PackageDelivery> groupedPackages) {
        return groupedPackages.stream().mapToDouble(t -> t.getValue()).reduce(0, Double::sum);
    }

    public static double groupRevenue(List<PackageDelivery> groupedPackage) {
        return groupedPackage.stream().mapToDouble(s -> s.getDistance()).reduce(0, Double::sum);
    }

    public static double totalGroupValues(List<PackageDelivery> allPackages) {
        return allPackages.stream().mapToDouble(s -> s.getValue()).reduce(0, Double::sum);
    }

    public static double totalGroupRevenue(List<PackageDelivery> list2) {
        return list2.stream().mapToDouble(l -> l.getDistance()).reduce(0, Double::sum);
    }

    private static int counter;
    private static List<PackageDelivery> currentPackageDeliveries;

    public void run() {
        counter++;
        int t = counter;
        try {
            for (int i = 0; i < currentPackageDeliveries.get(t - 1).getDistance(); i++) {
                Thread.sleep(1000);
                if ((currentPackageDeliveries.get(t - 1).getDistance() - i) >= 0.0) {
                    System.out.println("The package will arrive in " + (currentPackageDeliveries.get(t - 1).getDistance() - i) + " seconds");
                }
            }
        } catch (InterruptedException e) {

        }

    }
}

