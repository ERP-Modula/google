//GET workspaces
interface IWorkspacesTypes {
    id: string,
    name:string,
    description:string,
    favorite: boolean,
    lastEdit: Date,
    workflowsCount: number,
    workspaceIconPath: string
 }
 //GET workspaces/{id}
 interface IWorkspaceTypes {
    id: string,
    name:string,
    description:string,
    lastEdit: Date,
    updatedByUserId: string,
    foldersTree: IFolder,
 }
 interface IFolder {
    name: string,
    worflows: IWorkflowShortInfo[],
    childrenFolders: IFolder[],
 }
 interface IWorkflowShortInfo {
    id: string,
    name: string,
    description: string,
    scheduling: {
        enable: boolean,
        interval: number
    },
    type: "MANUAL" | "INITED_BY_EVENT",
    isActive: boolean,
    isArchived: boolean,
    usedModules: string[],
    created: Date,
    createdByUserId: string,
    lastEdit: Date,
    updatedByUserId: string,
    executionCount: number,
    lastExecution: Date,
 }
 //GET workspaces/{id}/workflows/{id}
 
 
 interface IWorkflowInfo {
    shortInfo: IWorkflowShortInfo,
    steps: IStep[],
 }
 
 
 interface IStep {
    id: string,
    type: "action" | "trigger" | "lib",
    // пример google-sheets:watchRows
    source: string,
    prevStepId: string[],
    nextStepId: string[],
    metadata:{
        location:{
            x: number,
            y: number
        },
     restore: {
         // значения “селектов” непосредственно, своеобразный кэш
         parameters: {
             [key: string]: string
         }
 }
    },
    parametersConfiguration:{
        [key: string]: string,
    }
 }
 
 
 //GET workspaces/{id}/workflows/{id}/logs
 
 
 interface ILog {
    id:          string;
    duration:       number;
    startDate: Date;
    operations:     number;
    eventType:      "EXECUTION_END" | "FAILED";
    type:           "MANUAL" | "INITED_BY_EVENT" | "SCHEDULED";
    timestamp:      Date;
    status:         "success" | "error";
 }
 
 
 //GET modules
 
 
 interface IModuleShortInfo {
    id: string
    name: string
    label: string   
    description: string
    iconPath: string
    public: boolean
    theme: string
    actions: IModuleHandler
    triggers: IModuleHandler,
    categories: string[],
 }
  
 
 interface IModuleHandler {
     id: string
     name: string
     label: string
     description: string
     category: string
 }
 
 
 
 
 // GET modules/{module_id}
 
 interface IModule {
     id: string,
     name: string,
     label: string,
     description: string,
     iconPath: string,
     public: boolean,
     theme: string,
    actions: IAction[],
    triggers: ITrigger[],
 }
 

 interface IAction {
     name: string,
     label: string,
     description: string,
     // то что модуль предоставит наружу, набор полей, доступных в любом следующем модуле
     outputInterface: IInterface[],
     inputParameters: IParameter[],
 }

 interface IInterface {
    name: string;
    type: TypeEnum;
    label: string;
    // в Make присутствовало, если type: date, видимо чтобы показывать еще и время
    time?: boolean;
    // если это не просто поле, а объект, тут описывается его структура
    spec?: IInterface[];
}

 export enum TypeEnum {
    Any = "any",
    Array = "array",
    Boolean = "boolean",
    Buffer = "buffer",
    Collection = "collection",
    Date = "date",
    Email = "email",
    Filename = "filename",
    Number = "number",
    Select = "select",
    Text = "text",
    URL = "url",
    Uinteger = "uinteger",
}


 interface IParameter {
    name: string,
    label: string,
    requred: boolean,
    options?: IParameterOptions, 
    // строка с подсказкой
    help?: string
 }

 interface IParameterOptions {
    options: INestedOptions[],
 }

 interface INestedOptions {
    name: string,
    type: TypeEnum,
    label: string,
    required: boolean,
    options?: INestedFieldOption[],
    help?: string,
    // если параметр вложенный, то есть после заполнения одного поля, требуется заполнить несколько зависимых, тут описывается их структура
    spec?: IParameter[],
 }

 interface INestedFieldOption {
    label: string,
    value: string,
    type: TypeEnum,
    // если выбрана опция, для которой существуют зависимые поля, тут описывается их структура
    nested?: IParameter[],
    default?: boolean,
 }

 interface ITrigger {
    name: string,
    label: string,
    description: string,
    // конфиг времени и нтревалов запуска
    startIntervalConfiguration: IStartIntervalConfiguration,
    // то что модуль предоставит наружу, набор полей, доступных в любом следующем модуле
     outputInterface: IInterface[],
    parameters: IParameter[],
 }

 interface IStartIntervalConfiguration {
    
 }
 
 // Также должны быть ручки на создание рабочих пространств, изменения,удаления. Тоже касается и папок, рабочих процессов и т.п.
 //  Сделать CRUD операции на каждый из сущностей
 // POST workspaces/{id}/workflows/{id}/steps - ручка, которая вызывается при нажатии + и добавления нового действия/триггера/элемента-библиотеки
 // добавляется IStep

