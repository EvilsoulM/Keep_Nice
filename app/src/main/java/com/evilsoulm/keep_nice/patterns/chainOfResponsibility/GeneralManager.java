package com.evilsoulm.keep_nice.patterns.chainOfResponsibility;

/**
 * Author by mazixuan
 * Data:2016-10-24 19:52
 * Project:Keep_Nice
 * Detail:
 */

public class GeneralManager extends Leader {
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() <= 30) {
            System.out.println("请假人：" + request.getEmpName() + ",天数：" + request.getLeaveDays() + ",理由：" + request.getReason());
            System.out.println("审批人：" + this.name + " 总经理，审批通过！");
        } else {
//          if (this.nextLeader != null ) {//如果有下一个继承者
//              //让下一个继承者处理请求
//              this.nextLeader.handleRequest(leader);
//          }
            //总经理上面没人了，所以不往下发送请求。
            System.out.println("请假申请，最终不通过！最终审批人：" + this.name + "  总经理");
        }
    }
}
