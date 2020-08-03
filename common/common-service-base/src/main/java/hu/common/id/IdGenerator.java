package hu.common.id;

/**
 * @description:
 * @version: 2.0, 2019-10-25 09:11
 * @author: liujinhu
 */
public interface IdGenerator {


    /**
     * 工作进程 id
     * @author liujinhu
     * @Description 工作进程 id
     * @date 2019-11-05 09:20
     * @param workId
     * @return long
     */
    public long nextId(long workId) ;

    /**
     *  批量获取 id
     * @author liujinhu
     * @Description 批量获取 id
     * @date 2019-11-05 09:21
     * @param workId  工作进程 id
     * @param size  id 数
     * @return long
     */
    public long nextIdBatch(long workId,int size) ;


}
