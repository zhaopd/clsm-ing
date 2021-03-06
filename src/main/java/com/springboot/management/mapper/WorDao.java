package com.springboot.management.mapper;
/*
 *@Author 李恒彪
 * @date 2020/05/04
 *
 */
import com.springboot.management.vo.Bank;
import com.springboot.management.vo.Wor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WorDao {
    void save(Wor wor);

    void delete(String id);

    void update(Wor wor);

    Wor findByQuestion(String question);

    List<Wor> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    List<Wor> findQuestionOrName(@Param("start") Integer start, @Param("rows") Integer rows,Wor wor);

    Integer findTotals();

    Integer findTotalsByBankId(Integer bankId);

    Wor findOne(Integer id);

    Wor findByNumber(Integer number,Integer bankId);

    void updateStatus(Integer id,Integer status);

    Integer totalsSelect(Wor wor);
}
