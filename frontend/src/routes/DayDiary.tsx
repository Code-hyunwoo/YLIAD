import { Link } from "react-router-dom";
import base from "./Base.module.css"
import Navbar from "../components/layout/Navbar";
import Stars2 from "../components/layout/Stars2";
import styles from "./DayDiary.module.css"

function DayDiary(){

    const content = "오늘의 일기. 이걸 계속 이렇게 하는게 맞는건가 싶다. 여러가지로 너무 짜증이 나는데, 발표자를 사다리타기로 뽑자고하질 않나."
    
    
    let bgcolor = 'blue'
    if(bgcolor === 'red'){
        bgcolor = '#FB5E3B95'
    } else if(bgcolor === 'pink'){
        bgcolor = '#FFB7EB95'
    } else if(bgcolor === 'purple'){
        // bgcolor = '#DCA3FF95'
        bgcolor = '#CA77FE95'
    } else if(bgcolor === 'yellow'){
        bgcolor = '#FFE69295'
    } else if(bgcolor === 'blue'){
        bgcolor = '#6AA6FF95'
    } else if(bgcolor === 'green'){
        bgcolor = '#D3FFB095'
    }
    
    
    
    
    
    
    return (
        <>
            <Navbar />
            <Stars2 />
            <div className={base.container}> 
                <div id={styles.contentP} 
                style={{ backgroundColor:`${bgcolor}`}}>
                    
                </div>

            </div>
        
        </>

    );
}

export default DayDiary;