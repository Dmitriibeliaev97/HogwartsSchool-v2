package ru.hogwarts.school.services.test;

import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.dto.AvatarDTO;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.services.AvatarService;

import java.io.IOException;
import java.util.List;
@Service
@Transactional
@Profile("test")
public class AvatarServiceTest implements AvatarService {
    @Override
    public void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException {

    }

    @Override
    public Avatar findAvatar(Long studentId) {
        return null;
    }

    @Override
    public List<AvatarDTO> findAvatarByPage(int pageNumber, int pageSize) {
        return null;
    }
}
