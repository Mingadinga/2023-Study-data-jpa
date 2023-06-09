package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import study.datajpa.entity.Item;
import study.datajpa.entity.Member;

public interface ItemRepository extends JpaRepository<Item, String>, JpaSpecificationExecutor<Member> {
}
