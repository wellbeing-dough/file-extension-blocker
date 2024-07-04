package com.extension.block.extension.domain.component;

import com.extension.block.extension.domain.entity.FileExtension;
import com.extension.block.extension.repository.FileExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FileExtensionsCrawler {

    private final FileExtensionRepository fileExtensionRepository;

    @Transactional
    public void fetchAndSaveNewExtensions() throws IOException {
        String url = "https://namu.wiki/w/%ED%99%95%EC%9E%A5%EC%9E%90/%EB%AA%A9%EB%A1%9D";
        Document document = Jsoup.connect(url).get();

        List<FileExtension> fileExtensions = new ArrayList<>();

        // Select the table containing the "종류" and "비고" columns
        Element table = document.select("table._6A2URz2V").first();
        if (table != null) {
            Elements rows = table.select("tr");
            for (Element row : rows) {
                Elements cells = row.select("td");
                if (cells.size() == 2) {
                    String type = cells.get(0).text().trim();
                    String notes = cells.get(1).text().trim();
                    FileExtension fileExtension = new FileExtension(type, notes);
                    fileExtensions.add(fileExtension);
                }
            }
        }

        // 데이터베이스에서 모든 기존 항목을 가져옴
        List<FileExtension> existingExtensions = fileExtensionRepository.findAll();

        // 빠른 조회를 위해 기존 항목의 extensionName을 집합으로 생성
        Set<String> existingExtensionNames = existingExtensions.stream()
                .map(FileExtension::getExtensionName)
                .collect(Collectors.toSet());

        // 데이터베이스에 이미 존재하지 않는 확장자만 필터링
        List<FileExtension> newExtensions = fileExtensions.stream()
                .filter(extension -> !existingExtensionNames.contains(extension.getExtensionName()))
                .collect(Collectors.toList());

        // 새로운 커스텀 확장자를 모두 저장
        fileExtensionRepository.saveAll(newExtensions);
    }

    @Transactional
    public void crawlAndSave() throws IOException {
        String url = "https://namu.wiki/w/%ED%99%95%EC%9E%A5%EC%9E%90/%EB%AA%A9%EB%A1%9D";
        Document document = Jsoup.connect(url).get();

        List<FileExtension> fileExtensions = new ArrayList<>();

        // Select the table containing the "종류" and "비고" columns
        Element table = document.select("table._6A2URz2V").first();
        if (table != null) {
            Elements rows = table.select("tr");
            for (Element row : rows) {
                Elements cells = row.select("td");
                if (cells.size() == 2) {
                    String type = cells.get(0).text().trim();
                    String notes = cells.get(1).text().trim();
                    FileExtension fileExtension = new FileExtension(type, notes);
                    fileExtensions.add(fileExtension);
                }
            }
        }

        // Save all extracted custom extensions to the repository
        fileExtensionRepository.saveAll(fileExtensions);
    }


}
