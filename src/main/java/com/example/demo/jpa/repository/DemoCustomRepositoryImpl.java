package com.example.demo.jpa.repository;

import com.example.demo.jpa.model.Parent;
import com.example.demo.jpa.model.QChild;
import com.example.demo.jpa.model.QParent;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public class DemoCustomRepositoryImpl extends QuerydslRepositorySupport implements DemoCustomRepository {

    public DemoCustomRepositoryImpl() {
        super(Parent.class);
    }

    @Override
    public List findParentWithChild() {

        QParent parent = QParent.parent;
        QChild child = QChild.child;
        List<Parent> parents = from(parent)
                .leftJoin(parent.childs, child)
                .where(child.age.gt(12))
//                .where(parent.childs.any().age.gt(12))
                .fetch();
        return parents;
    }
}
