package com.mycompany.airlinereservations;

/**
 *
 * @author Naweed
 */

import java.util.Scanner;

public class AirlineReservations {
    // Initializes all elements to false:
    private static boolean[] seats = new boolean[10];
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        while (true) {
            System.out.println("Please type 1 for First Class or 2 for Economy: ");
            int section = input.nextInt();
            
            if (section == 1) {
                int seat = assignSeat(0, 4); // Assigns a seat in first-class section:
                if (seat == -1) { // If first-class section is full, ask to be placed in economy section
                    System.out.println("First-class section is full. Would you like to be placed in the Economy section? (y/n)");
                    char choice = input.next().charAt(0);
                    if (choice == 'y') {
                        seat = assignSeat(5, 9); // Assigns a seat in economy section:
                        if (seat == -1) { // If economy section is also full, inform the passenger and exit
                            System.out.println("I'm sorry, the plane is full. Next flight leaves in 3 hours.");
                            break;
                        }
                    } else { // If the passenger doesn't want to be placed in the economy section, exit
                        System.out.println("Next flight leaves in 3 hours.");
                        break;
                    }
                }
                printBoardingPass(seat, "First Class");
                break;
            } else if (section == 2) {
                int seat = assignSeat(5, 9); // Assigns a seat in economy section:
                if (seat == -1) { // If economy section is full, ask to be placed in first-class section
                    System.out.println("Economy section is full. Would you like to be placed in the First Class section? (y/n)");
                    char choice = input.next().charAt(0);
                    if (choice == 'y') {
                        seat = assignSeat(0, 4); // Assigns a seat in first-class section:
                        if (seat == -1) { // If first-class section is also full, inform the passenger and exit
                            System.out.println("I'm sorry, the plane is full. Next flight leaves in 3 hours.");
                            break;
                        }
                    } else { // If the passenger doesn't want to be placed in the first-class section, exit
                        System.out.println("Next flight leaves in 3 hours.");
                        break;
                    }
                }
                printBoardingPass(seat, "Economy");
                break;
            } else { // If input is not 1 or 2, ask again:
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
    
    private static int assignSeat(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (!seats[i]) {
                seats[i] = true;
                return i;
            }
        }
        return -1; // If no seat is available in the specified section, return -1:
    }
    
    private static void printBoardingPass(int seat, String section) {
        System.out.println("Boarding Pass");
        System.out.println("Seat Number: " + (seat + 1));
        System.out.println("Section: " + section);
    }
}

