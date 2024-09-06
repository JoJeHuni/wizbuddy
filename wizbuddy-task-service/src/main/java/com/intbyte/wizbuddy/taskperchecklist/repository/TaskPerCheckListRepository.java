package com.intbyte.wizbuddy.taskperchecklist.repository;

import com.intbyte.wizbuddy.taskperchecklist.domain.entity.TaskPerCheckList;
import com.intbyte.wizbuddy.taskperchecklist.domain.entity.TaskPerCheckListId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TaskPerCheckListRepository extends JpaRepository<TaskPerCheckList, TaskPerCheckListId> {

    // task를 통한 삭제 JPQL
    @Modifying
    @Transactional
    @Query("DELETE FROM TaskPerCheckList t WHERE t.taskCode = :taskCode")
    void deleteByTask(@Param("taskCode") Integer taskCode);

    // checkList를 통한 삭제 JPQL
    @Modifying
    @Transactional
    @Query("DELETE FROM TaskPerCheckList t WHERE t.checkListCode = :checkListCode")
    void deleteByCheckList(@Param("checkListCode") Integer checkListCode);

}