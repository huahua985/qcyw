package qcyw.xchqcyws.common.sql;

import qcyw.xchqcyws.common.untils.StringUtils;

/**
 * sql操作工具类
 *
 * @date 2022/7/26
 * @Description
 */
public class SqlUtil {
    /**
     * 仅支持字母、数字、下划线、空格、逗号（支持多个字段排序）
     */
    public static String SQL_PATTERN = "[a-zA-Z0-9_\\ \\,]+";

    /**
     * 检查字符，防止注入绕过
     */
    public static String escapeOrderBySql(String value) {
        if (StringUtils.isNotEmpty(value) && !isValidOrderBySql(value)) {
            return StringUtils.EMPTY;
        }
        return value;
    }

    /**
     * 验证 order by 语法是否符合规范
     */
    public static boolean isValidOrderBySql(String value) {
        return value.matches(SQL_PATTERN);
    }

    /**
     * 获取Ext的列表数据的分页信息
     *
     * @return 分页信息对象
     */
    /*public static RecPageInfor getRecPageInfor() {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        RecPageInfor rpi = new RecPageInfor();
        String cntPerPageStr = String.valueOf(pageSize);
        if (cntPerPageStr == null || "".equals(cntPerPageStr))
            throw new BusinessException("每页记录数参数没有设置");
        String pageIndexStr = String.valueOf(pageNum);
        int start = 1;
        try {
            if (pageIndexStr != null && !"".equals(pageIndexStr))
                start = Integer.parseInt(pageIndexStr);
        } catch (NumberFormatException e) {
            throw new BusinessException("分页的起始页参数不是有效的整数", e);
        }
        int limit = Integer.parseInt(cntPerPageStr);
        rpi.setCntPerPage(limit);
        rpi.setIPage(start);
        return rpi;
    }*/
}
