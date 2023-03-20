package Auxiliary;

import Organization.Organization;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class OrganizatonSort {
    public static void sort(Vector<Organization> org){
        Collections.sort(org, Comparator.comparing(Organization::getName));
    }
    public static void revSort(Vector<Organization> org){
        Collections.sort(org, Comparator.comparing(Organization::getName).reversed());
    }

}
