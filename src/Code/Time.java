package Code;

public class Time implements Comparable<Time> {
    private int week;
    private int dayOfWeek;
    private int hour;

    /*构造方法*/
    public Time() {
        this.week = 0;
        this.dayOfWeek = 0;
        this.hour = 0;
    }

    public Time(int week, int dayOfWeek, int hour) {
        this.week = week;
        this.dayOfWeek = dayOfWeek;
        this.hour = hour;
    }

    /*增加一小时*/
    public void addHour() {
        if (this.hour == 23) {
            this.hour = 0;
            if (this.dayOfWeek == 7) {
                this.dayOfWeek = 1;
                this.week++;
            } else {
                this.dayOfWeek++;
            }
        } else {
            this.hour++;
        }
    }

    public int getWeek() {
        return week;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public int getHour() {
        return hour;
    }

    @Override
    public int compareTo(Time o) {
        if (this.week > o.week) {
            return 1;
        } else if (this.week < o.week) {
            return -1;
        } else {
            if (this.dayOfWeek > o.dayOfWeek) {
                return 1;
            } else if (this.dayOfWeek < o.dayOfWeek) {
                return -1;
            } else {
                if (this.hour > o.hour) {
                    return 1;
                } else if (this.hour < o.hour) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }

    /*打印时间*/
    @Override
    public String toString() {
        return "第" + week + "周 " + "星期" + dayOfWeek + " " + hour + "点";
    }
}
