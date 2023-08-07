package ru.hogwarts.school.services;

import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;

import java.io.IOException;
import java.util.Collection;

public interface AvatarService {
    void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException;
    Avatar findAvatar(Long studentId);
    Collection<Avatar> findAvatarByPage(int pageNumber, int pageSize);
}
