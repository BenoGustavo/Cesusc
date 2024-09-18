export interface IResponse {
    status: number;
    message: string;
    error: IReponseError;
    data: Object;
}

interface IReponseError {
    error: string;
}