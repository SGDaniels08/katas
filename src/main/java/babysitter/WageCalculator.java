package babysitter;

public class WageCalculator {
    public int calculateShiftWage(int startingHour, int endingHour, int bedtime) {
        validateShiftTimes(startingHour, endingHour);

        if(startingHour>=bedtime)
            return 8;
        if(startingHour>=0&& startingHour<4)
            return 16;
        return 12;
    }

    private void validateShiftTimes(int startingHour, int endingHour) {
        if (startingTimeIsInvalid(startingHour))
            throw new InvalidStartTimeException(startingHour);
        if (endingTimeIsInvalid(endingHour))
            throw new InvalidEndTimeException(endingHour);
        if(shiftIsInvalid(startingHour, endingHour))
            throw new InvalidTimePunchesException();
    }

    private boolean startingTimeIsInvalid(int startingHour) {
        return startingHour < 17 && startingHour > 3;
    }

    private boolean endingTimeIsInvalid(int endingHour) {
        return endingHour > 4 && endingHour < 18;
    }

    private boolean shiftIsInvalid(int startingHour, int endingHour) {
        startingHour = convertTimeToShiftRelativeTime(startingHour);
        endingHour = convertTimeToShiftRelativeTime(endingHour);
        return startingHour>=endingHour;
    }

    private int convertTimeToShiftRelativeTime(int startingHour) {
        if (startingHour<12){
            startingHour +=24;
        }
        return startingHour;
    }

}
