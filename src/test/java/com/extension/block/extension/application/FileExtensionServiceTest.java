package com.extension.block.extension.application;

import com.extension.block.extension.domain.component.ExtensionName;
import com.extension.block.extension.domain.entity.CustomBlockFileExtension;
import com.extension.block.extension.exception.CustomBlockFileExtensionAlreadyExistException;
import com.extension.block.extension.repository.CustomBlockFileExtensionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FileExtensionServiceTest {


    @Autowired
    private FileExtensionService fileExtensionService;

    @Autowired
    private CustomBlockFileExtensionRepository customBlockFileExtensionRepository;

    @AfterEach
    public void after() {
        customBlockFileExtensionRepository.deleteAll();
    }

    @Test
    void 동시에_10개의_커스텀_확장자_추가_요청이_처리된다() throws InterruptedException {
        // given
        String extensionNameValue = "JPG";
        ExtensionName extensionName = new ExtensionName(extensionNameValue);

        // when
        int threadCount = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(() -> {
                try {
                    fileExtensionService.addCustomExtension(extensionName);
                } finally {
                    latch.countDown();
                }
            });
        }
        latch.await();

        // then
        long count = customBlockFileExtensionRepository.count();
        // 중복 없이 하나만 저장되어야 함
        assertEquals(1, count);
    }


}