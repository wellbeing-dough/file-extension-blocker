package com.extension.block.extension.domain.component;

import com.extension.block.extension.domain.entity.CustomExtension;
import com.extension.block.extension.repository.CustomExtensionRepository;
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
public class ExtensionsCrawler {

    private final CustomExtensionRepository customExtensionRepository;

    @Transactional
    public void fetchAndSaveNewExtensions() throws IOException {
        String url = "https://namu.wiki/w/%ED%99%95%EC%9E%A5%EC%9E%90/%EB%AA%A9%EB%A1%9D";
        Document document = Jsoup.connect(url).get();

        List<CustomExtension> customExtensions = new ArrayList<>();

        // Select the table containing the "종류" and "비고" columns
        Element table = document.select("table._6A2URz2V").first();
        if (table != null) {
            Elements rows = table.select("tr");
            for (Element row : rows) {
                Elements cells = row.select("td");
                if (cells.size() == 2) {
                    String type = cells.get(0).text().trim();
                    String notes = cells.get(1).text().trim();
                    CustomExtension customExtension = new CustomExtension(type, notes);
                    customExtensions.add(customExtension);
                }
            }
        }

        // 데이터베이스에서 모든 기존 항목을 가져옴
        List<CustomExtension> existingExtensions = customExtensionRepository.findAll();

        // 빠른 조회를 위해 기존 항목의 extensionName을 집합으로 생성
        Set<String> existingExtensionNames = existingExtensions.stream()
                .map(CustomExtension::getExtensionName)
                .collect(Collectors.toSet());

        // 데이터베이스에 이미 존재하지 않는 확장자만 필터링
        List<CustomExtension> newExtensions = customExtensions.stream()
                .filter(extension -> !existingExtensionNames.contains(extension.getExtensionName()))
                .collect(Collectors.toList());

        // 새로운 커스텀 확장자를 모두 저장
        customExtensionRepository.saveAll(newExtensions);
    }

    @Transactional
    public void crawlAndSave() throws IOException {
        String url = "https://namu.wiki/w/%ED%99%95%EC%9E%A5%EC%9E%90/%EB%AA%A9%EB%A1%9D";
        Document document = Jsoup.connect(url).get();

        List<CustomExtension> customExtensions = new ArrayList<>();

        // Select the table containing the "종류" and "비고" columns
        Element table = document.select("table._6A2URz2V").first();
        if (table != null) {
            Elements rows = table.select("tr");
            for (Element row : rows) {
                Elements cells = row.select("td");
                if (cells.size() == 2) {
                    String type = cells.get(0).text().trim();
                    String notes = cells.get(1).text().trim();
                    CustomExtension customExtension = new CustomExtension(type, notes);
                    customExtensions.add(customExtension);
                }
            }
        }

        // Save all extracted custom extensions to the repository
        customExtensionRepository.saveAll(customExtensions);
    }


}
