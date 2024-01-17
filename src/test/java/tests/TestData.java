package tests;

public class TestData {

    public final String city = "Moscow", //Москва Moscow
            invalidCity = "abcdefgsa",
            categoryPharmacies = "Pharmacies", //Аптеки Pharmacies
            categoryMuseums = "Museums", //Музеи Museums
            categoryCafe = "Cafe", //Кафе Cafe
            companyMuseum = "Останкинская башня",
            companyPharmacies = "Здравсити",
            companyCafe = "Блюр Лаунж Бар",
            incompletePhoneNumber = "+79333555",
            landlinePhoneNumber = "+7 (423) 249-77-77",
            unsupportedPhoneNumber = "+204322314641",
            invalidLengthPhoneNumber = "+81231",
            fictitiousPhoneNumber = "+7 (521) 231-22-13",
            validPhoneNumber = "+7 (931) 599-38-68",
            incompletePhoneNumberMessage = "The phone number is incomplete",  //Номер телефона указан не полностью
            landlinePhoneNumberMessage = "Invalid phone number. Enter mobile phone number", //Некорректный номер телефона. Введите мобильный номер телефона
            unsupportedPhoneNumberMessage = "This international destination is not supported", //Данное международное направление не поддерживается
            invalidLengthPhoneNumberMessage = "Number of digits in the phone number: 5. Maximum allowed length is from 11 to 15", //Количество цифр в номере телефона: 5. Допустимая длина от 11 до 15
            fictitiousPhoneNumberMessage = "Fictitious phone number", //Несуществующий номер телефона
            emptyPhoneNumberMessage = "Required field"; //Поле обязательно для заполнения
}
