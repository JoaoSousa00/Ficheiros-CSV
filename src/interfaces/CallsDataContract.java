package interfaces;

/**
 * <p>
 * <strong>Author: </strong><br>
 * Joao Sousa<br>
 * <strong>Description: </strong><br>
 * Interface that 
 * </p>
 */
public interface CallsDataContract {

    /**
     * Calculates Average Minutes Per Number
     * 
     * Prints the average minutes wasted by each phone number
     */
    public double calculateAverageMinutesPerNumber();
   
    /**
     * Calculates Average Minutes Per Area
     * 
     * @param area_code Code of the area
     * @param outputFileName Name of the output file
     * @return the average minutes wasted by each area existing in the data file
     *      and stores the result in a file whos name is given by argument.
     */
    public double calculateAverageMinutesPerArea(String area_code, String outputFileName);
    
}
