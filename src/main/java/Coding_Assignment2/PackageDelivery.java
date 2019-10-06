package Coding_Assignment2;
import lombok.AccessLevel;
import lombok.Getter;

import java.time.LocalDate;

@Getter(AccessLevel.PUBLIC)
public class PackageDelivery {
    public String targetLocation;
    public double distance;
    public double value;
    public LocalDate deliveryDate;

}
