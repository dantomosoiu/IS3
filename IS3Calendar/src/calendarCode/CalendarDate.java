package calendarCode;

public class CalendarDate {

    // class to store a date for use with the calendar
    // NOTE: Only accurate until the next leap year.
    // constants to provide an initial day for the date id
    private static int FIRST_DAY = 1, FIRST_MONTH = 1, FIRST_YEAR = 1990;
    // day, month and year of the Date
    public int day, month, year;
    // unique id given from the date. Counting from FIRST_DAY, FIRST_MONTH, FIRST_YEAR
    public int dateID;

    public CalendarDate(int the_day, int the_month, int the_year) {
        day = the_day;
        month = the_month;
        year = the_year;

        dateID = getDateID(day, month, year);
    }

    public CalendarDate(int id) {

        CalendarDate cd = getDateFromID(id);
        day = cd.day;
        month = cd.month;
        year = cd.year;

        dateID = id;
    }

    public static int getDateID(CalendarDate cd) {
        // from the date, get the appropriate date ID
        return getDateID(cd.day, cd.month, cd.year);
    }

    public int getID() {
        return dateID;
    }

    public static int getDateID(int d, int m, int y) {
        // get the date ID from the day, month and year

        if (d > 31 || d < 1 || m > 12 || m < 1 || y < FIRST_YEAR) {
            return -1;
        }

        int no_years = y - FIRST_YEAR;
        int no_months = m - FIRST_MONTH;
        int no_days = d - FIRST_DAY;

        int y_val = no_years * 365;

        for (int i = FIRST_YEAR; i < no_years + FIRST_YEAR; i++) {
            if (isLeap(i)) {
                y_val++;
            }
        }

        int m_val;

        while (true) {
            m_val = 1;
            if (no_months == 0) {
                break;
            }
            m_val += 31;
            if (no_months == 1) {
                break;
            }
            m_val += getDaysOfMonth(2, y);
            if (no_months == 2) {
                break;
            }
            m_val += 31;
            if (no_months == 3) {
                break;
            }
            m_val += 30;
            if (no_months == 4) {
                break;
            }
            m_val += 31;
            if (no_months == 5) {
                break;
            }
            m_val += 30;
            if (no_months == 6) {
                break;
            }
            m_val += 31;
            if (no_months == 7) {
                break;
            }
            m_val += 31;
            if (no_months == 8) {
                break;
            }
            m_val += 30;
            if (no_months == 9) {
                break;
            }
            m_val += 31;
            if (no_months == 10) {
                break;
            }
            m_val += 30;
            if (no_months == 11) {
                break;
            }
            m_val += 31;
            break;
        }

        int d_val = no_days;

        return y_val + m_val + d_val;
    }

    public static CalendarDate getDateFromID(int id) {
        // given a date id, get the relevant calendar date
        if (id < 0) {
            return null;
        }

        int dayCounter = id;
        int yearCounter = FIRST_YEAR;

        int yearDays;
        if (isLeap(FIRST_YEAR)) {
            yearDays = 366;
        } else {
            yearDays = 365;
        }

        while (dayCounter > yearDays) {
            dayCounter -= yearDays;

            yearCounter++;
            if (isLeap(yearCounter)) {
                yearDays = 366;
            } else {
                yearDays = 365;
            }
        }
        
        int no_years = yearCounter;
        int no_months;
        int no_days;

        int curPassedDays = 31;

        while (true) {
            no_months = 1;
            if (dayCounter <= curPassedDays) { //dayCounter is in January
                no_days = dayCounter;
                break;
            }
            while (true) {
                no_months++;
                if (dayCounter <= curPassedDays + getDaysOfMonth(no_months, no_years)) { //dayCounter is in current month
                    no_days = dayCounter - curPassedDays;
                    break;
                }
                curPassedDays += getDaysOfMonth(no_months, no_years); //adding no of days or month to currPassedDays
            }
            break;
        }

        return new CalendarDate(no_days, no_months, no_years);

    }

    public static String getDay(int d, int m, int y) {
        // Given the date, get the day

        int the_id = getDateID(d, m, y);


        switch (the_id % 7) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 0:
                return "Sunday";
            default:
                return "ANYDAY";
        }
    }

    @Override
    public String toString() {
        // turn the CalendarDate object into a string

        return "" + day + "-" + month + "-" + year;

    }

    public static CalendarDate moveDay(int i, CalendarDate d) {
        return getDateFromID(d.dateID + i);
    }

    public static CalendarDate moveWeek(int i, CalendarDate d) {
        return getDateFromID(d.dateID + i * 7);
    }

    public static CalendarDate moveMonth(int i, CalendarDate d) {
        if ((d.month + i) % 12 > 0 && (d.month + i) < 13) {
            return new CalendarDate(d.day, (d.month + i) % 12, d.year);
        } else if ((d.month + i) % 12 > 0) {
            return new CalendarDate(d.day, 1, d.year + 1);
        } else if ((d.month + i) < 1) {
            return new CalendarDate(d.day, 12, d.year - 1);
        } else {
            return new CalendarDate(d.day, (12), d.year);
        }
    }

    public static boolean isLeap(int year) {
        if (((year % 4 == 0) && (year % 100 != 0)) || ((year % 100 == 0) && (year % 400 == 0))) {
            return true;
        } else {
            return false;
        }
    }

    public static int getDaysOfMonth(int month, int year) {
        switch (month) {
            case 1:
                return 31;
            case 2:
                if (isLeap(year)) {
                    return 29;
                }
                return 28;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                return -1;
        }
    }

    public static int getDayNumberFromDayName(String day) {

        if (day.toLowerCase().equals("monday")) {
            return 1;
        }
        if (day.toLowerCase().equals("tuesday")) {
            return 2;
        }
        if (day.toLowerCase().equals("wednesday")) {
            return 3;
        }
        if (day.toLowerCase().equals("thursday")) {
            return 4;
        }
        if (day.toLowerCase().equals("friday")) {
            return 5;
        }
        if (day.toLowerCase().equals("saturday")) {
            return 6;
        }
        if (day.toLowerCase().equals("sunday")) {
            return 7;
        }
        return -1;
    }
}
