export default class dateUtils {
    static formatDate(date: Date, format: string): string {
        let formattedDate = '';
        const parts = format.split(/[^YMD]+/);
        const separator = format.match(/[^YMD]+/)?.[0]??"-";

        parts.forEach(part => {
            switch (part) {
                case 'YYYY':
                    formattedDate += date.getFullYear();
                    break;
                case 'MM':
                    formattedDate += `${date.getMonth() + 1}`.padStart(2, '0');
                    break;
                case 'DD':
                    formattedDate += `${date.getDate()}`.padStart(2, '0');
                    break;
                default:
                    break;
            }

            formattedDate += separator;
        });
        return formattedDate.slice(0, -separator.length);
    }
}