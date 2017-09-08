public class SmsChannelInfo {
    private String channelName;
    private Integer priorityOrder;

    public SmsChannelInfo(){}

    public SmsChannelInfo(String channelName, Integer priorityOrder) {
        this.channelName = channelName;
        this.priorityOrder = priorityOrder;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Integer getPriorityOrder() {
        return priorityOrder;
    }

    public void setPriorityOrder(Integer priorityOrder) {
        this.priorityOrder = priorityOrder;
    }
}
