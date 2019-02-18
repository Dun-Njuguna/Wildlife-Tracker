--
-- PostgreSQL database dump
--

-- Dumped from database version 10.6 (Ubuntu 10.6-0ubuntu0.18.04.1)
-- Dumped by pg_dump version 10.6 (Ubuntu 10.6-0ubuntu0.18.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: animals; Type: TABLE; Schema: public; Owner: njuguna
--

CREATE TABLE public.animals (
    id integer NOT NULL,
    name character varying,
    rangername character varying,
    type character varying,
    age character varying,
    location character varying,
    health character varying,
    citingtime timestamp without time zone
);


ALTER TABLE public.animals OWNER TO njuguna;

--
-- Name: animals_id_seq; Type: SEQUENCE; Schema: public; Owner: njuguna
--

CREATE SEQUENCE public.animals_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.animals_id_seq OWNER TO njuguna;

--
-- Name: animals_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: njuguna
--

ALTER SEQUENCE public.animals_id_seq OWNED BY public.animals.id;


--
-- Name: ranger; Type: TABLE; Schema: public; Owner: njuguna
--

CREATE TABLE public.ranger (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE public.ranger OWNER TO njuguna;

--
-- Name: ranger_id_seq; Type: SEQUENCE; Schema: public; Owner: njuguna
--

CREATE SEQUENCE public.ranger_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ranger_id_seq OWNER TO njuguna;

--
-- Name: ranger_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: njuguna
--

ALTER SEQUENCE public.ranger_id_seq OWNED BY public.ranger.id;


--
-- Name: animals id; Type: DEFAULT; Schema: public; Owner: njuguna
--

ALTER TABLE ONLY public.animals ALTER COLUMN id SET DEFAULT nextval('public.animals_id_seq'::regclass);


--
-- Name: ranger id; Type: DEFAULT; Schema: public; Owner: njuguna
--

ALTER TABLE ONLY public.ranger ALTER COLUMN id SET DEFAULT nextval('public.ranger_id_seq'::regclass);


--
-- Data for Name: animals; Type: TABLE DATA; Schema: public; Owner: njuguna
--

COPY public.animals (id, name, rangername, type, age, location, health, citingtime) FROM stdin;
\.


--
-- Data for Name: ranger; Type: TABLE DATA; Schema: public; Owner: njuguna
--

COPY public.ranger (id, name) FROM stdin;
1	Dun
2	Dun
3	Dun
4	Duncan
5	Dun
6	Duncan
7	Dun
8	Dun
9	Dun
10	Duncan
11	Dun
12	Duncan
13	Dun
\.


--
-- Name: animals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: njuguna
--

SELECT pg_catalog.setval('public.animals_id_seq', 6, true);


--
-- Name: ranger_id_seq; Type: SEQUENCE SET; Schema: public; Owner: njuguna
--

SELECT pg_catalog.setval('public.ranger_id_seq', 13, true);


--
-- Name: animals animals_pkey; Type: CONSTRAINT; Schema: public; Owner: njuguna
--

ALTER TABLE ONLY public.animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);


--
-- Name: ranger ranger_pkey; Type: CONSTRAINT; Schema: public; Owner: njuguna
--

ALTER TABLE ONLY public.ranger
    ADD CONSTRAINT ranger_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

