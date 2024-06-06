import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class dummy {
    public static void main(String[] args) {
        int page=2;
        int size=1;
        List<String> resultList=new ArrayList<>();
        resultList.add("abc");
        resultList.add("abcd");
        resultList.add("acd");
        resultList.add("efg");
        int totalElements = resultList.size();
        int totalPages = (int) Math.ceil((double) totalElements / size);
        int start = page * size;
        int end = Math.min(start + size, totalElements);
        List<String> lst=resultList.subList(start,end);
        for(String val:lst){
            System.out.println(val);
        }
//        random UUID
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());

//        List<MyDTO> paginatedResult = resultList.subList(start, end);
//
//        return new PageImpl<>(paginatedResult, PageRequest.of(page, size), totalElements);

    }
}
