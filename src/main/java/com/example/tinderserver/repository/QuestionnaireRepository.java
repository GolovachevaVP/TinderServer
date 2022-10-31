package com.example.tinderserver.repository;

import com.example.tinderserver.dto.QuestionnaireDto;
import com.example.tinderserver.enums.GenderTypeEnum;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestionnaireRepository {
    private List<QuestionnaireDto> questionnaireDtoList;
    private  int questionnaireId = 0;

    public QuestionnaireRepository() {
        questionnaireDtoList = new ArrayList<>();
        questionnaireDtoList.add(new QuestionnaireDto(
                GenderTypeEnum.MALE,
                "Алексей",
                "Вся моя жизнь – это череда разных интересных событий. " +
                        "Для кого-то они покажутся приключениями, но для меня – это обыденные вещи." +
                        " Только мне не хватает рядом родного человека. " +
                        "Если честно, в моей жизни не хватает времени, чтобы искать вторую половинку," +
                        " с которой я бы разделил свою жизнь. Поэтому я решил завести тут анкету." +
                        " Тем более в интернете очень просто познакомиться с интересным человеком."
        ));

        questionnaireDtoList.add(new QuestionnaireDto(
                GenderTypeEnum.MALE,
                "Евгений",
                "Не люблю спорт – вместо этого я трачу время на инвестиции в будущее, которое мечтаю разделить с тобой. Кстати, я имел в виду просмотр футбола, а тренажерный зал – это святое. Я буду демонстрировать тебе свою силу, чтобы защищать и оберегать хрупкую тебя."
        ));

        questionnaireDtoList.add(new QuestionnaireDto(
                GenderTypeEnum.MALE,
                "Дмитрий",
                "Дмитрий. Моя жизнь полна интересных событий. Единственное, чего мне не хватает – любимая девушка рядом. Я разделил бы с ней эту насыщенную жизнь, поэтому и решил завести здесь анкету. В интернете гораздо проще познакомиться с интересным собеседником."
        ));

        questionnaireDtoList.add(new QuestionnaireDto(
                GenderTypeEnum.FEMALE,
                "Ольга",
                "Я - журналист, модель  и просто хороший человек. Только пока нет у меня того единственного, которому захочется посвятить жизнь! Люблю заказывать в Арабике кофе Американо, первую зелень весной, летний дождь, а зимой - как под ногами скрипит только что выпавший снег. Люблю, когда вокруг кипит жизнь, так как я сама очень активная и общительная. Я не люблю, когда люди пытаются мной манипулировать, не люблю, когда мне страшно или холодно… Хочу найти серьезного молодого человека с сильным характером, который уверен в себе, умеет ценить, уважать и любить женщину. Того, который способен самый обычный день превратить в праздник. Встретив своего особенного мужчину, я бы хотела создать такие отношения, чтобы всегда понимать друг друга без слов."
        ));
    }

    public QuestionnaireDto getSearchQuestionnaire(Long chatId){
        QuestionnaireDto result;
        if (questionnaireId > questionnaireDtoList.size() - 1) {
            questionnaireId = 0;
        }
        result = questionnaireDtoList.get(questionnaireId);
        questionnaireId++;
        return result;
    }

}
