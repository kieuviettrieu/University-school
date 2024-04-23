import styled from "tachyons-components";
import ReactLoading from 'react-loading';
import './index.css';

export function SmoothHorizontalScrolling(e, time, amount, start){
    var eAmt = amount/100;
    var curTime=0;
    var scrollCounter=0;
    const y=window.scrollY;
    while(curTime <= time){
        window.setTimeout(SHS_B, curTime, e, scrollCounter, eAmt, start, y);
        curTime +=time / 100;
        scrollCounter++;
    }
    window.scrollTo(0,y);
}

function SHS_B(e, sc, eAmt, start, y){
    e.scrollLeft = eAmt * sc + start;
}


export const Article = styled('div')`
ma2 items-center justify-center flex flex-column flex-wrap`;


export const Loading = (color = 'black') => (
    <Article key={'bars'}>
        <ReactLoading type={"bars"} color={color} height={'20%'} width={'20%'}/>
    </Article>
);