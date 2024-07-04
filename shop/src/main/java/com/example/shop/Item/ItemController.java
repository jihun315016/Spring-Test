package com.example.shop.Item;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor // 롬북 문법, private final ItemRepository itemRepository; 이걸 쓰기 위한 문법
// 이거하면 itemRepository가 등록되고 이 변수에 db 입출력 함수들이 막 들어있게 된다.
// 이거 안 쓰면 아래처럼 생성자 만들고 Autowired 해야함
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;

//    @Autowired
//    public ItemController(ItemRepository itemRepository) {
//        this.itemRepository = itemRepository;
//    }

    @GetMapping("/list")
    String list(Model model) {
        // model.addAttribute("전달할 데이터 이름", "데이터")
        List<Item> result = itemRepository.findAll();

        // 룸북 기능 -> @ToString 애너테이션 : 객체 멤버를 보여주는 toString() 메서드 지원
        // 룸북 없이 toString() 출력하면 이상한 문자열 나옴
        System.out.println(new Item().toString());
        model.addAttribute("items", result);
        return "list.html";
    }

    @GetMapping("/write")
    String write(Model model) {
        return "write.html";
    }

    // url 작명은 동사보다는 명사로 하는 게 좋음
    @PostMapping("/add")
    String writePost(@RequestParam String title, @RequestParam Integer price) {
    // String writePost(@ModelAttribute Item item) {
        itemService.saveItem(title, price);
        return "redirect:/list";
    }

    // id를 url 파라미터라고 부름
    @GetMapping("/detail/{id}")
    //ResponseEntity<String> detail(@PathVariable Long id, Model model) {
    String detail(@PathVariable Long id, Model model) throws Exception {
        Optional<Item> result = itemRepository.findById(id);
        // Optional 타임은 이 변수가 비어있을 수도 있고 Item 타입일 수도 있다는 뜻
        // 결과가 없는 경우를 대비하기 위한 타입
        // 이 변수의 값을 쓸 때는 .get()을 써야 함

        //throw new Exception();

//        try {
//            // throw new Exception("이런 저런 이유임");
//            if (result.isPresent()) {
//                // result 값 없는데 get하면 오류 남
//                System.out.println(result.get());
//                model.addAttribute("item", result.get());
//                return "detail.html";
//            } else {
//                return "redirect:/list";
//                // 에러 코드 -> 에러 원인을 알려주는 코드
//                //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("에러 메시지");
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return "redirect:/list";
//        }
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
        //ResponseEntity<String> detail(@PathVariable Long id, Model model) {
    String edit(Model model, @PathVariable Long id) {
        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("data", result.get());
            return "edit.html";
        } else {
            return "redirect:/list";
        }
    }

    @PostMapping("/edit")
        //ResponseEntity<String> detail(@PathVariable Long id, Model model) {
    String editItem(@RequestParam String title, @RequestParam Integer price, Long id) {
        Item item = new Item();
        item.setId(id);
        item.setTitle(title);
        item.setPrice(price);
        
        // id가 1인 행이 있으니까 덮어쓰기(수정) -> jpa로 수정하는 방법
        itemRepository.save(item);
        return "redirect:/list";
    }


    @DeleteMapping("/item")
    ResponseEntity<String> deleteItem(@RequestParam Long id) {
        itemRepository.deleteById(id);
        // ajax로 데이터를 주고 받을 때 리다이렉트 안 됌
        // return "redirect:/list";
        return ResponseEntity.status(200).body("삭제 완료");
    }


//    @ExceptionHandler(Exception.class)
//    public void handler() {
//        // 같은 클래스의 메서드 안에서 오류가 나면 대신 이 안에 있는 코드를 실행해 줌
//        // try catch를 써도 파라미터 잘못 입력되거나 하는건 못 잡음
//        // return ResponseEntity.status().body();
//    }
    // 근데 이것도 컨트롤러 많아지면 귀찮은데
    // 모든 컨트롤러 파일을 에러를 캐치하려면 @ControllerAdvice -> MyExceptionHandler 클래스 참고


    @GetMapping("/test1")
    String editItem() {
        System.out.println("요청 들어옴");
        return "redirect:/list";
    }
}
// jpa 사용하기
// 1. repository 만들기
// 2. 원하는 클래스에 repository 등록
// 3. repository.문법() 쓰기
