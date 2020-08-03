package hu.springcloud.feign.server.entity;

import hu.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;


/**
 * <p>
 * IP地址
 * </p>
 *
 * @author
 * @since 2019-10-11
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Ip对象", description = "IP地址")
//@EntityListeners(value = EntityLister.class)
@Entity
@Table(name = "ip", uniqueConstraints = @UniqueConstraint(columnNames = "area"))
public class Ip extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String ipStart;

    private String ipEnd;

    private String area;

    private String operator;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ipStartNum;

    private Long ipEndNum;

    @CreatedDate
    private Date createDate;
    @CreatedBy
    private String createBy;

}
