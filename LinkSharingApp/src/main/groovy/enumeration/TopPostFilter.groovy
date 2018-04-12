package enumeration

import groovy.time.TimeCategory

enum TopPostFilter {
    TODAY("Today"),
    ONE_WEEK("Last Week"),
    ONE_MONTH("Last Month"),
    ONE_YEAR("Last Year")

    private final String displayName;

    TopPostFilter(String displayName) {
        this.displayName = displayName
    }

    String getDisplayName() {
        return displayName
    }
    String getName() {
        return name()
    }

    Date getFromDate(){
        Date today = new Date()
        Date fromDate
        use(TimeCategory) {
            if(this.equals(TODAY)){
                fromDate = today.clearTime()
            }
            else if(this.equals(ONE_WEEK)){
                fromDate = today-1.week
            }
            else if(this.equals(ONE_MONTH)){
                fromDate = today-1.month
            }
            else if(this.equals(ONE_YEAR)){
                fromDate = today-1.year
            }
            return fromDate
        }
    }

    static TopPostFilter changeForm(String s){
        if (s.equals("TODAY")){
            return TODAY
        }else if(s.equals("ONE_WEEK")){
            return ONE_WEEK
        }else if(s.equals("ONE_MONTH")){
            return ONE_MONTH
        }else if(s.equals("ONE_YEAR")){
            return ONE_YEAR
        }else {
            return TODAY
        }
    }

}