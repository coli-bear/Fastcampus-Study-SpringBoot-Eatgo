package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.MenuItem;
import kr.co.fastcampus.eatgo.domain.MenuItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class MenuItemServiceTests {

    private MenuItemService menuItemService;

    @Mock
    private MenuItemRepository menuItemRepository;


    @BeforeEach // @Test 실행 전 실행, 아래 테스트는 스프링 테스트가 아니므로 의존성을 수동으로 주읩해줘야한다.
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        menuItemService = new MenuItemService(menuItemRepository);

    }

    @Test
    public void bulkUpdate() {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(MenuItem.builder()
            .name("Kimchi")
            .build()
        );
        menuItems.add(MenuItem.builder()
            .name("Gukbob")
            .build()
        );
        menuItemService.bulkUpdate(1L, menuItems);

        verify(menuItemRepository, times(2)).save(any());
    }
}