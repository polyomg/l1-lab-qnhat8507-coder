package poly.edu.tv00059_lab6.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.tv00059_lab6.entity.Account;

public interface AccountDAO extends JpaRepository<Account, String> {
}
