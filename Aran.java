/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viva3;


/**
 *
 * @author Jawwad Ibne Kabir & Zannat Ul Ferdous
 */




public class Aran {
    private int level;
    private int jobAdvancement;
    private static int[] jobAdvMap = {10, 30, 60, 100, 160, 260};

    // Empty constructor
    public Aran() {
        this.level = 300;
        this.jobAdvancement = -1;
    }

    // Constructor with jobAdvancement parameter
    public Aran(int jobAdvancement) {
        this();
        setLevelByJobAdvancement(jobAdvancement);
    }

    // Accessor method for level
    public int getLevel() {
        return level;
    }

    // Mutator method for level
    public void setLevel(int level) {
        if (level > 0 && level < 301) {
            this.level = level;
            setJobAdvancementByLevel(level);
        } else {
            System.out.println("Invalid level input. Level should be between 1 and 300.");
        }
    }

    // Accessor method for jobAdvancement
    public int getJobAdvancement() {
        return jobAdvancement;
    }

    // Mutator method for jobAdvancement
    public void setJobAdvancement(int jobAdvancement) {
        if (jobAdvancement >= -1 && jobAdvancement < 6) {
            this.jobAdvancement = jobAdvancement;
        } else {
            System.out.println("Invalid job advancement input. Job advancement should be between -1 and 5.");
        }
    }

    // Set level based on jobAdvancement
    private void setLevelByJobAdvancement(int jobAdvancement) {
        if (jobAdvancement >= 0 && jobAdvancement < jobAdvMap.length) {
            this.level = jobAdvMap[jobAdvancement];
            this.jobAdvancement = jobAdvancement;
        } else {
            System.out.println("Invalid job advancement input. Job advancement should be between 0 and " + (jobAdvMap.length - 1) + ".");
        }
    }

    // Set jobAdvancement based on level
    private void setJobAdvancementByLevel(int level) {
        for (int i = 0; i < jobAdvMap.length; i++) {
            if (level == jobAdvMap[i]) {
                this.jobAdvancement = i;
                break;
            }
        }
    }

    // Static method to check if input is valid
 public static boolean isValid(String input) {
    // Input is a string only consisting of characters 'B', 'P', 'T', and 'M'
    if (!input.matches("[BPTM]+")) {
        return false;
    }

    // 'P' can only be followed by 'T' and 'T' can only be followed by 'M'
    for (int i = 0; i < input.length() - 1; i++) {
        char currentChar = input.charAt(i);
        char nextChar = input.charAt(i + 1);

        if ((currentChar == 'P' && nextChar != 'T') || (currentChar == 'T' && nextChar != 'M')) {
            return false;
        }
    }

    // 'B' may or may not exist only before 'P'
    return !input.contains("BB") && !input.contains("B[^P]");
}
    // toString method
    @Override
    public String toString() {
        return "Aran's Information:\n" +
               "Level: " + level + "\n" +
               "Job Advancement: " + jobAdvancement;
    }
    
    public static void main(String[] args) {
        // Test the Aran class
        System.out.println("PTM              :     " + Aran.isValid("PTM"));
        System.out.println("PTMMTP           :     " + Aran.isValid("PTMMTP"));
        System.out.println("BPTMBPTM         :     " + Aran.isValid("BPTMBPTM"));
        System.out.println("PT               :     " + Aran.isValid("PT"));

        Aran aran1 = new Aran();
        System.out.println("\nAran Info \n" + aran1);

        Aran aran2 = new Aran(5);
        System.out.println("\nAran Info\n" + aran2);
    }
    
}




