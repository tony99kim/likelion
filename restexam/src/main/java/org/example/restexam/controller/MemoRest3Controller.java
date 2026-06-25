package org.example.restexam.controller;


import org.example.restexam.domain.Memo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api3/memos")
public class MemoRest3Controller {
    private final Map<Long, Memo> memos = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public ResponseEntity<List<Memo>> getMemos() {
        return ResponseEntity.ok(new ArrayList<>(memos.values()));
    }

    @GetMapping
    public ResponseEntity<Memo> getMemo(@PathVariable("id") Long id) {
        Memo memo  = memos.get(id);
        if(memo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(memo);
    }
}
