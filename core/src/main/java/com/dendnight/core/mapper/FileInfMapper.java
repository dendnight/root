package com.dendnight.core.mapper;

import com.dendnight.core.domain.FileInf;

public interface FileInfMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_inf
     *
     * @mbggenerated Sun Apr 06 17:47:23 CST 2014
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_inf
     *
     * @mbggenerated Sun Apr 06 17:47:23 CST 2014
     */
    int insert(FileInf record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_inf
     *
     * @mbggenerated Sun Apr 06 17:47:23 CST 2014
     */
    int insertSelective(FileInf record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_inf
     *
     * @mbggenerated Sun Apr 06 17:47:23 CST 2014
     */
    FileInf selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_inf
     *
     * @mbggenerated Sun Apr 06 17:47:23 CST 2014
     */
    int updateByPrimaryKeySelective(FileInf record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_inf
     *
     * @mbggenerated Sun Apr 06 17:47:23 CST 2014
     */
    int updateByPrimaryKey(FileInf record);
}