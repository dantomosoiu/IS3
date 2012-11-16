
import is3cal.DayView;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1007414g
 */
public class IS3Calendar {

    public static DayView dayView;
    
    public static MonthView monthView;
    
    public static ToDoView toDoView;

    public static ToDoView getToDoView() {
        return toDoView;
    }

    public static void setToDoView(ToDoView toDoView) {
        IS3Calendar.toDoView = toDoView;
    }

    public static WeekView getWeekView() {
        return weekView;
    }

    public static void setWeekView(WeekView weekView) {
        IS3Calendar.weekView = weekView;
    }

    public static YearView getYearView() {
        return yearView;
    }

    public static void setYearView(YearView yearView) {
        IS3Calendar.yearView = yearView;
    }
    
    public static WeekView weekView;
    
    public static YearView yearView;

    public DayView getDay() {
        return dayView;
    }

    public void setDay(DayView day) {
        this.dayView = day;
    }

    public MonthView getMonth() {
        return monthView;
    }

    public void setMonth(MonthView month) {
        this.monthView = month;
    }
    
    
    public IS3Calendar() {
    
        
    }
    
    
    public static void main(String[] arg){
        dayView = new DayView();
        monthView = new MonthView();
        yearView = new YearView();
        weekView = new WeekView();
        toDoView = new ToDoView();
        
        weekView.setVisible(true);
    }
    
    
    
}
