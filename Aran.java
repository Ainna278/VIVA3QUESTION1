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
   // Static method to check if input is valid
public static boolean isValid(String input) {
    // Input should contain at least one main character (PTMQ)
    if (!input.matches(".[PTMQ].")) {
        return false;
    }

    // Input is a string consisting of alphabets and digits
    if (!input.matches("[A-Za-z0-9]+")) {
        return false;
    }

    // 'P' can only be followed by 'T'
    // 'M' can only be followed by 'M'
    // 'Q' can only be followed by none
    // Rules on Main Characters can be broken due to the presence of Special Characters
    if (!input.matches("(PT|MM|Q|.[BDGH].)*")) {
        return false;
    }

    // 'B' may or may not exist only before 'P'
    // 'D' may or may not exist only before 'T'
    // 'G' may or may not exist after 'M'
    // 'H' may or may not exist after 'Q'
    if (!input.matches("(.B?P.)|(.D?T.)|(.G?M.)|(.H?Q.)")) {
        return false;
    }

    return true;
}

    // toString method
    @Override
    public String toString() {
        return "Aran's Information:\n" +
               "Level: " + level + "\n" +
               "Job Advancement: " + jobAdvancement;
    }
    
    public static void main(String[] args) {
 String[] testCases = new String[] {
 "PTM", "PTMMTP", "BPTMBPTM", "PT", "PTMQ", "PTMQH", "BPTMQH", "PTMQH",
"BPDTMGQH", 
 "PTMQH", "PTMQH", "12PTHQGM", "12PTQHMG", "12PTMGQH",
"PTMQBPTMQBPTMQ", "DTBP123QHMG", 
 "BTDP", "TP", "TBP", "BDT", "DTP", "ABCD", "D"
 };
 
 for(String input: testCases){
     System.out.printf("%-20s : %s\n", input, Aran.isValid(input));
 }
 
    }
    
}




